import com.aistar.pojo.Product;
import com.aistar.service.Impl.ProductServiceImpl;
import com.aistar.service.ProductService;
import com.github.pagehelper.Page;
import org.junit.Test;

import java.util.List;

public class ProductTest {
    @Test
    public void getAll(){
        ProductService service =  new ProductServiceImpl();
        Page<Product> page= service.getAllByPage(4);
        System.out.println(page);

    }
}
