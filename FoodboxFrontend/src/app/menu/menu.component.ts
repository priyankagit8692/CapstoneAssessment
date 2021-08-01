import {ApplicationModule, Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {MenuServiceService} from "../menu-service.service";
import {AppComponent} from "../app.component";
import {count} from "rxjs/operators";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  model:menu[];
  values:Quantity[] = [];
  total:number;
  searchText;
  headElements = ['ID', 'Item', 'Price', 'Quantity','Edit','Delete'];
  modalCart:cart={
    quantity1:0,
    quantity2:0,
    quantity3:0
  };

  
  constructor(private http:HttpClient, private router:Router,private menuService:MenuServiceService) { }

  ngOnInit() {
    if (sessionStorage.getItem("userData") == null) {
      this.router.navigate(['login']);
    }
    this.getItems();
  }


  clearLocal(){
    sessionStorage.clear();
  }

  getItems():void{
    this.menuService.getItems().subscribe((men: any[]) => {
      this.model = men;
      for (let i=0;i<this.model.length;i++){
        this.values.push(new Quantity());
        this.values[i].quantity=0;
      }
    });
  }


  getTotal():void{
    console.log(this.values);
    var i : number;
    let url = "http://localhost:8087/cart";
   
    this.modalCart.quantity1=this.values[0].quantity;
    if(this.values.length >1){
      this.modalCart.quantity2=this.values[1].quantity;
    }
   
    this.http.post<number>(url,this.values).subscribe(

      res=>{
        // AppComponent.total=res;
       
        sessionStorage.setItem('total',res.toString());
        this.total=res;
      },
      err=>{
        alert("Please select at least 1 item");
      }
    )
  
  }

  sort(event: any) {
    switch (event.target.value) {
      case "Low":
        {
          this.model = this.model.sort((low, high) => low.price - high.price);
          break;
        }

      case "High":
        {
          this.model = this.model.sort((low, high) => high.price - low.price);
          break;
        }

      case "Name":
        {
          this.model = this.model.sort(function (low, high) {
            if (low.item < high.item) {
              return -1;
            }
            else if (low.item > high.item) {
              return 1;
            }
            else {
              return 0;
            }
          })
          break;
        }

      default: {
        this.model = this.model.sort((low, high) => low.price - high.price);
        break;
      }

    }
    return this.model;

  }
}

export interface menu {
  id:string;
  item:string;
  price:number;
  quantity:number;
  url:string;
  formID:string;
  cartID:string;
}

export interface cart {
  quantity1:number;
  quantity2:number;
  quantity3:number;
}

export class Quantity {
  quantity:number;
}
