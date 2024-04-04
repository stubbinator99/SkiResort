import {Component, OnInit} from '@angular/core';
import {PassWithPrice} from "../model/pass";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-pass-details',
  templateUrl: './pass-details.component.html',
  styleUrl: './pass-details.component.css'
})
export class PassDetailsComponent implements OnInit {
  pass: PassWithPrice;

  constructor(
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.data.subscribe(data => {
      this.pass = data['pass'];
    });
  }
}
