import {Component, OnInit} from '@angular/core';
import {Pass} from "../model/pass";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-pass-details',
  templateUrl: './pass-details.component.html',
  styleUrl: './pass-details.component.css'
})
export class PassDetailsComponent implements OnInit {
  pass: Pass;

  constructor(
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.pass = history.state.pass;

    // let o = this.route.snapshot.queryParamMap.get('pass');
    // if (o instanceof Pass) {
    //   this.pass = o;
    // }
    //this.route.paramMap.subscribe(value => this.pass = value);
    //this.pass = this.route.pass;
    //this.pass = this.route.snapshot.params['pass'];

    // this.route.data.subscribe(data => {
    //   this.pass = data['pass'];
    // });
  }
}
