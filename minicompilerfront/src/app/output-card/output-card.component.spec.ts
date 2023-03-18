import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OutputCardComponent } from './output-card.component';

describe('OutputCardComponent', () => {
  let component: OutputCardComponent;
  let fixture: ComponentFixture<OutputCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OutputCardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OutputCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
