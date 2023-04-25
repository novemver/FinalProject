import { TestBed } from '@angular/core/testing';

import { FamilymembersService } from './familymembers.service';

describe('FamilymembersService', () => {
  let service: FamilymembersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FamilymembersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
