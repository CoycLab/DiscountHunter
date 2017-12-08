package com.github.coyclab.discounthunter;

import com.github.coyclab.discounthunter.http.IHttpClient;
import com.github.coyclab.discounthunter.mocks.Mocks;
import com.github.coyclab.discounthunter.model.ProductListParser;
import com.github.coyclab.discounthunter.model.product.IProductList;
import com.github.coyclab.discounthunter.utils.Category;
import com.github.coyclab.discounthunter.utils.Constants;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Constants.SDK_VERSION)
public class ProductListParserTest {

    private static final String URL = "example.com";
    private static final String EXPECTED_NAME = "Computer";
    private static final double EXPECTED_PRICE = 5.95;
    private static final String EXPECTED_ADDRESS = "Solomovoy, 80";
    private static final String EXPECTED_IMAGE_URL = "http://slavdvor.ru/img/b2ap3_thumbnail_akson-logo.png";
    private static final String EXPECTED_LOGO_URL = "https://im0-tub-by.yandex.net/i?id=85788cae39bbe61ef2767891241986ae-sr&n=13";

    private IHttpClient mHttpClient;

    @Before
    public void setUp() {
        mHttpClient = mock(IHttpClient.class);
    }

    @Test
    public void parseProductList() throws Exception {
        final InputStream mockedInputStream = Mocks.stream(Constants.TEST_JSON_FILE_NAME);
        when(mHttpClient.request(anyString())).thenReturn(mockedInputStream);
        final InputStream response = mHttpClient.request(URL);
        final IProductList productList = new ProductListParser(response).parse();

        assertTrue(productList.getProductList().size() == 2);
        assertEquals(productList.getProductList().get(0).getName(), EXPECTED_NAME);
        assertTrue(productList.getProductList().get(0).getPrice() == EXPECTED_PRICE);
        assertEquals(productList
                .getProductList()
                .get(1)
                .getSeller()
                .getShopList()
                .get(0)
                .getAddress(), EXPECTED_ADDRESS);

        assertEquals(productList.getProductList().get(1).getImage(),EXPECTED_IMAGE_URL);
        assertEquals(productList.getProductList().get(0).getSeller().getSellerLogo(),EXPECTED_LOGO_URL);

        assertEquals(productList.getProductList().get(0).getCategory(), Category.FOOD);
        assertEquals(productList.getProductList().get(1).getCategory(), Category.AUTO_GOODS);
    }
}