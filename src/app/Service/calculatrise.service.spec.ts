import { TestBed } from '@angular/core/testing';

import { CalculatriseService } from './calculatrise.service';

describe('CalculatriseService', () => {
  let service: CalculatriseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalculatriseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
