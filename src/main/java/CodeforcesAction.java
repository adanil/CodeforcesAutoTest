import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CodeforcesAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        System.out.println("Start action!");
        Project currentPrject = e.getProject();
        String taskUrl = Messages.showInputDialog(currentPrject,"URL: ","Insert task url",Messages.getQuestionIcon());

        try {
            Document doc = Jsoup.connect(taskUrl)
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();
            System.out.println(doc.text());
            Elements tests = doc.select(".sample-tests");
            System.out.println(tests.text());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
