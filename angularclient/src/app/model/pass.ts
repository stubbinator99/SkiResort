import {Price} from "../price";

/*export class Pass {
  passId: number;
  username: string;
  startDate: Date;
  endDate: Date;
  priceId: number;
}*/

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
  public static readonly ADULT = new PassCategory("Adult", "Ages 12 to 64");
  public static readonly CHILD = new PassCategory("Child", "Ages 6 and under");
  public static readonly MILITARY = new PassCategory("Military", "Veterans or active military");
  public static readonly SENIOR = new PassCategory("Senior", "Ages 65 and up");
  public static readonly YOUTH = new PassCategory("Youth", "Ages 7 to 11");

  private constructor(public readonly name: string, public readonly description: string) { }

  static getAllCategories(): PassCategory[] {
    return [
      PassCategory.ADULT,
      PassCategory.CHILD,
      PassCategory.MILITARY,
      PassCategory.SENIOR,
      PassCategory.YOUTH
    ];
  }
}

export class Pass {
  passId: number;
  username: string;
  startDate: Date;
  endDate: Date;
  price: Price;
}

/*let USDollar = new Intl.NumberFormat('en-US', {
  style: 'currency',
  currency: 'USD',
});*/
