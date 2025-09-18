import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarAlimentacion } from './listar-alimentacion';

describe('ListarAlimentacion', () => {
  let component: ListarAlimentacion;
  let fixture: ComponentFixture<ListarAlimentacion>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarAlimentacion]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarAlimentacion);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
