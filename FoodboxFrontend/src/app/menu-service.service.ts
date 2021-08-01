import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MenuServiceService {

  constructor(public http: HttpClient) { }
  public getItems():any{
    let url = "http://localhost:8087/menu";
    return this.http.get(url);
  }

  public deleteItem(id:any){
    let url = "http://localhost:8087";
    return this.http.delete(url+'/deleteItem?id='+id);
  }

  getFood(id: number): Observable<any> {
    let url = "http://localhost:8087";
    return this.http.get(`${url}/${id}`);
    }

  updateData(id: number, value: any):Observable<Object> {
    let url = "http://localhost:8087/updateData";
    return this.http.put(`${url}/${id}`, value);
    
  }

  
}
