import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearPorcino } from './crear-porcino';

describe('CrearPorcino', () => {
  let component: CrearPorcino;
  let fixture: ComponentFixture<CrearPorcino>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CrearPorcino]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CrearPorcino);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
