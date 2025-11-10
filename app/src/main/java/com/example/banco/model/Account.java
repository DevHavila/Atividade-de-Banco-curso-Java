package com.example.banco.model;

    public class Account {

        private Integer number;
        private String holder;
        private Double balance;
        private Double withdrawLimit;

        public Account(){
            super();
        }

        public Account(Integer number, String holder, Double balance, Double withdrawmit) {
            super();
            this.number = number;
            this.holder = holder;
            this.balance = balance;
            this.withdrawLimit = withdrawmit;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getHolder() {
            return holder;
        }

        public void setHolder(String holder) {
            this.holder = holder;
        }

        public String getBalance() {
            return String.format("%.2f",balance);
        }

        public Double getWithdrawmit() {
            return withdrawLimit;
        }

        public void deposit(Double amount) {
            balance += amount;
        }

        public void withdraw(Double amount) throws DomainException {
            if(amount > withdrawLimit) {
                throw new DomainException("The amount exceeds withdraw Limit");
            }
            if(balance < withdrawLimit) {
                throw new DomainException("Not enough balance");
            }

            balance -= amount;
        }

}
