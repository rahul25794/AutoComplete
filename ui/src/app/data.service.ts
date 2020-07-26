import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Country } from './country';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private URL = "http://localhost:7070/suggest";
  constructor(private http: HttpClient) { }
  public getList(term: string) {
    return this.http.get<Country[]>(`${this.URL}?term=${term.trim()}`);
  }
}
