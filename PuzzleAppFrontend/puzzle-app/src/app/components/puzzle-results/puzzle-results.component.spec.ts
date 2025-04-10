import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PuzzleResultsComponent } from './puzzle-results.component';

describe('PuzzleResultsComponent', () => {
  let component: PuzzleResultsComponent;
  let fixture: ComponentFixture<PuzzleResultsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PuzzleResultsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PuzzleResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
