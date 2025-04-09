import { Routes } from '@angular/router';
import { MainComponent } from './components/main/main.component';

export const routes: Routes = [
  { path: '', component: MainComponent, data: { renderMode: 'default' } },
  { path: '**', redirectTo: '', data: { renderMode: 'default' } },
];
