import { Component } from '@angular/core';
import {Pass, PassCategory, PassType} from "../model/pass";
import {ActivatedRoute, Router} from "@angular/router";
import {PassService} from "../services/pass.service";

@Component({
  selector: 'app-pass-form',
  templateUrl: './pass-form.component.html',
  styleUrl: './pass-form.component.css'
})
export class PassFormComponent {
  pass: Pass;
  passTypes: String[];
  passCategories: PassCategory[];
  passCategoryValue: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private passService: PassService
  ) {
    this.pass = new Pass();
    this.passTypes = Object.keys(PassType);
    this.passCategories = PassCategory.getAllCategories();
  }

  onSubmit() {
    this.passService.newPass(this.pass).subscribe(result => this.goToPassList());
  }

  goToPassList() {
    this.router.navigate(['passes']);
  }
}
