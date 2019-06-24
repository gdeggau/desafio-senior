import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClienteDetalhesComponent } from './cliente-detalhes.component';

describe('ClienteDetalhesComponent', () => {
  let component: ClienteDetalhesComponent;
  let fixture: ComponentFixture<ClienteDetalhesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClienteDetalhesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClienteDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
