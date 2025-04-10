import { Routes } from '@angular/router';
import { PuzzleResultsComponent } from './components/puzzle-results/puzzle-results.component';
import { PuzzleItemComponent } from './components/puzzle-item/puzzle-item.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { TimeResultsComponent } from './components/time-results/time-results.component';
import { LeaderboardResultsComponent } from './components/leaderboard-results/leaderboard-results.component';

export const routes: Routes = [
  { path: '', component: HomePageComponent, data: { renderMode: 'default' } },
  {
    path: 'puzzles',
    component: PuzzleResultsComponent,
    data: { renderMode: 'default' },
  },
  {
    path: 'puzzles/:id',
    component: PuzzleItemComponent,
    data: { renderMode: 'default' },
  },
  {
    path: 'times',
    component: TimeResultsComponent,
    data: { renderMode: 'default' },
  },
  {
    path: 'leaderboard',
    component: LeaderboardResultsComponent,
    data: { renderMode: 'default' },
  },
  { path: '**', redirectTo: '', data: { renderMode: 'default' } },
];
