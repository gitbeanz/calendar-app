interface Sharer {
    public void shareEvent(long userID, CalendarEvent event);
    public CalendarEvent removeSharedEvent(long userID, long eventID);
}