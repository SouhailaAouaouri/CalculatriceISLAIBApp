import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalculatriseComponent } from './calculatrise.component';

describe('CalculatriseComponent', () => {
  let component: CalculatriseComponent;
  let fixture: ComponentFixture<CalculatriseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CalculatriseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CalculatriseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
