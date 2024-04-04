export class Pass {
  passId: number;
  username: string;
  startDate: Date;
  endDate: Date;
  priceId: number;
}

export enum PassType {
  DAY,
  HALF_DAY,
  NIGHT,
  ALL_DAY,
  MULTI_DAY,
  MULTI_NIGHT,
  MULTI_ALL_DAY,
  SEASON
}

export class PassCategory {
  public static readonly ADULT = new PassCategory("Ages 12 to 64");
  public static readonly CHILD = new PassCategory("Ages 6 and under");
  public static readonly MILITARY = new PassCategory("Veterans or active military");
  public static readonly SENIOR = new PassCategory("Ages 65 and up");
  public static readonly YOUTH = new PassCategory("Ages 7 to 11");

  private constructor(public readonly description: string) { }
}

export class PassWithPrice {
  passId: number;
  username: string;
  startDate: Date;
  endDate: Date;
  priceId: number;
  price: string;
  passType: PassType;
  passCategory: PassCategory;
}

/*let USDollar = new Intl.NumberFormat('en-US', {
  style: 'currency',
  currency: 'USD',
});*/
