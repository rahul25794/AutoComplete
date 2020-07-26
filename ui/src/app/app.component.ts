import { Component, Injectable } from '@angular/core';
import { Country } from './country';
import { DataService } from './data.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
@Injectable()
export class AppComponent {
  constructor(private service: DataService) {
    this.loadFromServer();
  }
  title = 'Autocomplete';
  list = [];
  suggestions = [];
  hasSuggestions = false;
  term: string = '';
  suggest() {
    this.term = this.term.trim();
    this.filter(this.term);
    if (this.suggestions.length < 3) {
      this.loadFromServer();
    }
  }
  filter(term: string) {
    this.suggestions = this.list.filter(c => term === '' || c.name.toLowerCase().startsWith(term.toLowerCase()));
  }
  focus() {
    this.hasSuggestions = true;
  }
  blur() {
    this.hasSuggestions = false;
  }
  select(value: string) {
    this.term = value;
    this.hasSuggestions = false;
  }
  loadFromServer() {
    this.service.getList(this.term).subscribe(data => {
      this.list = data;
      this.filter(this.term);
    });
  }
}
