import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaderboardResultsComponent } from './leaderboard-results.component';

describe('LeaderboardResultsComponent', () => {
  let component: LeaderboardResultsComponent;
  let fixture: ComponentFixture<LeaderboardResultsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LeaderboardResultsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LeaderboardResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
