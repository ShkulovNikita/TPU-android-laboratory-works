package ru.tpu.android.laboratory_work;

import android.app.Application;

import ru.tpu.android.lab3.Student;
import ru.tpu.android.lab3.StudentsCache;
import ru.tpu.android.lab5.Repo;
import ru.tpu.android.lab5.ReposCache;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // region lab3
        StudentsCache studentsCache = StudentsCache.getInstance();
        studentsCache.addStudent(new Student("Хардкод", "Хардкодович", "Хардкодов"));
        studentsCache.addStudent(new Student("Петр", "Иванович", "Петров"));
        studentsCache.addStudent(new Student("Михаил", "Васильевич", "Синицын"));
        studentsCache.addStudent(new Student("Степан", "Иванович", "Иванов"));
        // endregion lab3

        // region lab5
        /*
        ReposCache reposCache = ReposCache.getInstance();
        Repo repo1 = new Repo();
        Repo repo2 = new Repo();
        Repo repo3 = new Repo();
        repo1.fullName = "name1";
        repo1.description = "descr1";
        repo2.fullName = "name2";
        repo2.description = "descr2";
        repo3.fullName = "name3";
        repo3.description = "descr3";
        reposCache.addRepo(repo1);
        reposCache.addRepo(repo2);
        reposCache.addRepo(repo3);*/
        // endregion lab5
    }
}
