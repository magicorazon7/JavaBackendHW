class Transaction {
    enum Type { DEPOSIT, WITHDRAW, TRANSFER, EXCHANGE }
    final Type type;
    final int clientId;
    final int receiverId; // optional
    final Currency from;
    final Currency to;
    final double amount;

    public Transaction(Type type, int clientId, int receiverId,
                       Currency from, Currency to, double amount) {
        this.type = type;
        this.clientId = clientId;
        this.receiverId = receiverId;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
}