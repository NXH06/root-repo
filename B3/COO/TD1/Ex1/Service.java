public abstract class Service {
    protected int nbUse;
    protected int cost;
    public Service() {
        this.nbUse = 0;
    }
    public int getCost() {
        return this.cost;
    }
    public int getNbUse() {
        return this.nbUse;
    }
    public final void isUsedBy(ServiceUser user) throws NotEnoughMoneyException {
        int availableMoney = user.getMoney();
        if (availableMoney < cost) {
            throw new NotEnoughMoneyException();
        }
        execute();
        nbUse++;
        user.setMoney(availableMoney - cost);
    }
    protected abstract void execute();
}