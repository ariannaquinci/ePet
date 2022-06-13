package presentation.graphics;

import java.io.IOException;

public interface PutInAdoptionGraphic {
    void setKind();
    void post() throws IOException;
    void goBack() throws IOException;
}
