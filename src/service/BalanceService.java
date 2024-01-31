package service;

import repository.BalanceRepositoryjdbc;

public class BalanceService {
    private final BalanceRepositoryjdbc balanceRepositoryjdbc;

    public BalanceService(BalanceRepositoryjdbc balanceRepositoryjdbc) {
        this.balanceRepositoryjdbc = balanceRepositoryjdbc;
    }

}
