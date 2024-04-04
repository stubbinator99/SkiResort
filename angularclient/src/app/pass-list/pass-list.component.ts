import {Component, OnInit} from '@angular/core';
import {PassWithPrice} from "../model/pass";
import {PassService} from "../services/pass.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-pass-list',
  templateUrl: './pass-list.component.html',
  styleUrl: './pass-list.component.css'
})
export class PassListComponent implements OnInit {
  username: string;
  passes: PassWithPrice[];

  constructor(
    private route: ActivatedRoute,
    private passService: PassService
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.username = params['username'];
      this.loadPassList();
    });
  }

  private loadPassList() {
    this.passService.getAllPassesForUser(this.username)
      .subscribe(passes => this.passes = passes);
  }
}
