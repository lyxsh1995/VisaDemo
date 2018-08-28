package com.lyxsh.visademo.Bean;

import java.util.ArrayList;

/**
 * Created by xushengheng on 2018/8/21.
 */
public class BankCardList extends ArrayList<BankCardList.BankCard> {

    public static class BankCard{
        String cardID;
        int type;

        public String getCardID() {
            return cardID;
        }

        public void setCardID(String cardID) {
            this.cardID = cardID;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
