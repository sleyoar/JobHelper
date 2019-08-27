import com.entity.Resume;
import com.service.ContactService;
import org.junit.Test;

public class TestUSer {

    @Test
    public void testid() {
        Resume resume = new Resume();
        Resume resume1 = new Resume();
        System.out.println(resume.getResumeId());
        System.out.println(resume1.getResumeId());
    }

}
