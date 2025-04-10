import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimeResultsComponent } from './time-results.component';

describe('TimeResultsComponent', () => {
  let component: TimeResultsComponent;
  let fixture: ComponentFixture<TimeResultsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TimeResultsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TimeResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
