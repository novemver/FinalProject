import { TestBed } from '@angular/core/testing';

import { ElderService } from './elder.service';

describe('ElderService', () => {
  let service: ElderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ElderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
