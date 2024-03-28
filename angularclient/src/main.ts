import { appConfig } from './app/app.config';
import {AppModule} from "./app/app.module";
import {platformBrowserDynamic} from "@angular/platform-browser-dynamic";
//import { bootstrapApplication } from '@angular/platform-browser';
//import { AppComponent } from './app/app.component';

//bootstrapApplication(AppComponent, appConfig)
platformBrowserDynamic([appConfig.providers]).bootstrapModule(AppModule)
  .catch((err) => console.error(err));
