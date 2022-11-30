package org.dieschnittstelle.ess.basics.reflection.stockitemtypes;

import org.dieschnittstelle.ess.basics.IStockItem;
import org.dieschnittstelle.ess.basics.annotations.StockItem;

import static org.dieschnittstelle.ess.utils.Utils.show;

public class Ice implements IStockItem {
        private int units;

        private String brandname;

        private int price;

        public Ice() {
            show("Ice: constructor invoked");
        }


        @Override
        public int getUnits() {
            return this.units;
        }

        @Override
        public void setUnits(int units) {
            this.units = units;
        }

        @Override
        public void initialise(int units,String brandname) {
            show("Ice: initialise() invoked");

            this.units = units;
            this.brandname = brandname;
        }

        @Override
        public String toString() {
            return String.format("<Ice %s %d %d>", this.brandname, this.units, this.price);
        }

        public String getBrandname() {
            return brandname;
        }

        public void setBrandname(String brandname) {
            this.brandname = brandname;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            show("Ice: setPrice() invoked");

            this.price = price;
        }



}
