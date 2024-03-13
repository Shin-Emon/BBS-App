package app.yabrum.data;

public record Post(
        int id,
        String name,
        String content
) {
    @Override
    public String toString() {
        return "ID: " + id + "\nNAME: " + name + "\nCONTENT: " + content;
    }
}
