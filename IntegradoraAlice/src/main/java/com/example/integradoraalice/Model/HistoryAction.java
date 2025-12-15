package com.example.integradoraalice.Model;

//Sirve para guardar las acciones del sistema en el historial.

public class HistoryAction {
        private String actionType;
        private int loanId;
        private int bookId;
        private int userId;
        private int previousAvailableCopies;

        public HistoryAction(String actionType, int loanId, int bookId, int previousAvailableCopies) {
            this.actionType = actionType;
            this.loanId = loanId;
            this.bookId = bookId;
            this.previousAvailableCopies = previousAvailableCopies;
        }

        // ADD_TO_WAITLIST
        public HistoryAction(String actionType, int bookId, int userId) {
            this.actionType = actionType;
            this.bookId = bookId;
            this.userId = userId;
        }

        public String getActionType() {
            return actionType;
        }

        public int getLoanId() {
            return loanId;
        }

        public int getBookId() {
            return bookId;
        }

        public int getUserId() {
            return userId;
        }

        public int getPreviousAvailableCopies() {
            return previousAvailableCopies;
        }
}

