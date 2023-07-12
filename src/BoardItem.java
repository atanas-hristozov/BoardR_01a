import jdk.jshell.Snippet;

import java.time.LocalDate;

public class BoardItem {
    public String title;
    public LocalDate dueDate;
    public Status status;

    public BoardItem(String title,LocalDate dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        this.status = Status.Open;
    }
    public Status advanceStatus(){
        if(this.status == Status.Open) {
            status = Status.Todo;
            return status;
        }
        if(this.status == Status.Todo) {
            status = Status.InProgress;
            return status;
        }
        if(this.status == Status.InProgress) {
            status = Status.Done;
            return status;
        }
        if(this.status == Status.Done) {
            status = Status.Verified;
            return status;
        }
        return status;
    }
    public Status revertStatus() {
        if(this.status == Status.Verified) {
            status = Status.Done;
            return status;
        }
        if(this.status == Status.Done) {
            status = Status.InProgress;
            return status;
        }
        if(this.status == Status.InProgress) {
            status = Status.Todo;
            return status;
        }
        if(this.status == Status.Todo) {
            status = Status.Open;
            return status;
        }
        return status;
    }

    public String viewInfo(){
        StringBuilder viewInfo = new StringBuilder();
        viewInfo.append(String.format("'%s', [%s | %s]", title, status, dueDate));
        return viewInfo.toString();
    }
}
