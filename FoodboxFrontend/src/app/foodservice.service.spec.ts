import { TestBed } from '@angular/core/testing';

import { FoodserviceService } from './foodservice.service';

describe('FoodserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FoodserviceService = TestBed.get(FoodserviceService);
    expect(service).toBeTruthy();
  });
});
