import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoPorcino } from './listado-porcino';

describe('ListadoPorcino', () => {
  let component: ListadoPorcino;
  let fixture: ComponentFixture<ListadoPorcino>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListadoPorcino]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListadoPorcino);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
