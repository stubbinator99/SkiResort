import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassFormComponent } from './pass-form.component';

describe('PassFormComponent', () => {
  let component: PassFormComponent;
  let fixture: ComponentFixture<PassFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PassFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PassFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
