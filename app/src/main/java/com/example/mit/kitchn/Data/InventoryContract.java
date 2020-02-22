package com.example.mit.kitchn.Data;

import android.provider.BaseColumns;

public class InventoryContract {

    public static abstract class InventoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "Inventory";
        public static final String INVENTORY_ID = "_id";
        public static final String COLUMN_ITEM_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_QUANTITY = "quantity";

        public static final int QUANTITY_ONE = 1;
        public static final int QUANTITY_TWO = 2;
        public static final int QUANTITY_THREE = 3;
    }
}
