import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Food } from '../food';
import { MenuServiceService } from '../menu-service.service';

@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.css']
})
export class UpdateItemComponent implements OnInit {

  id: number;
  food: Food;

  constructor(private route: ActivatedRoute,private router: Router,
    private menuservice: MenuServiceService) { }

  ngOnInit() {
    this.food = new Food();

    this.id = this.route.snapshot.params['id'];
    
    this.menuservice.getFood(this.id)
      .subscribe(data => {
        console.log(data)
        this.food = data;
      }, error => console.log(error));
  }

  updateData() {
    this.menuservice.updateData(this.id, this.food)
      .subscribe(data => {
        console.log(data);
        this.food = new Food();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateData();    
  }

  gotoList() {
    this.router.navigate(['/merchantMenu']);
  }

}
