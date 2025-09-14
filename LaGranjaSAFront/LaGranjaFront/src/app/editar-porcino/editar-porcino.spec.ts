import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarPorcino } from './editar-porcino';

describe('EditarPorcino', () => {
  let component: EditarPorcino;
  let fixture: ComponentFixture<EditarPorcino>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarPorcino]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarPorcino);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
