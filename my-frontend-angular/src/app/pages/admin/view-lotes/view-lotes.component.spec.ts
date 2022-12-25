import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewLotesComponent } from './view-lotes.component';

describe('ViewLotesComponent', () => {
  let component: ViewLotesComponent;
  let fixture: ComponentFixture<ViewLotesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewLotesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewLotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
