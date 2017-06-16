package com.bwei.retrofitdemo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.bwei.retrofitdemo.cookie.CookiesManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import static android.R.attr.password;
import static android.R.attr.type;

public class MainActivity extends Activity {


    static String username = "11111111111" ;
    static String password = "1" ;
    static String postkey = "1503d" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        findViewById(R.id.get_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                get();

            }
        });


        findViewById(R.id.pic_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toPic();
            }
        });


    }

    public void get(){


        OkHttpClient client = new OkHttpClient.Builder().cookieJar(new CookiesManager()).build();

        ExecutorService exe =  Executors.newCachedThreadPool() ;

//        http://qhb.2dyt.com/Bwei/long
        Retrofit retrofit = new Retrofit.Builder()
                //主域名
                .baseUrl("http://www.2dyt.com/")
                //返回的内容  用Gson 转化bean
                .addConverterFactory(ScalarsConverterFactory.create())
                // 改变回调的线程
//                .callbackExecutor(exe)
//                .callFactory(client)
                .client(client)
//                检测接口中定义的所有方法的注解是否ok
                .validateEagerly(false)
//                .addCallAdapterFactory()
                .build();


        //动态代理
        LoginService loginService =  retrofit.create(LoginService.class);

//        loginService.getLogin().enqueue(new Callback<LoginBean>() {
//            @Override
//            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
//                System.out.println("response = " + response.body().getRet_msg());
//            }
//
//            @Override
//            public void onFailure(Call<LoginBean> call, Throwable t) {
//
//            }
//        });

//        public Call<LoginBean> getLogin(@Query("username") String username, @Query("password") String password,@Query("postkey") String postkey );

//        loginService.getLogin("11111111111","1","1503d") .enqueue(new Callback<LoginBean>() {
//            @Override
//            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
//
//                System.out.println("response = " + response.body().getRet_msg());
//            }
//
//            @Override
//            public void onFailure(Call<LoginBean> call, Throwable t) {
//
//            }
//        });


//        public Call<LoginBean> getLoginMap(@QueryMap Map<String,String> map);

        Map map = new HashMap();
        map.put("username","11111111111");
        map.put("password","1");
        map.put("postkey","1503d");
//
//
//        loginService.getLoginMap(map).enqueue(new Callback<LoginBean>() {
//            @Override
//            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
//
//                System.out.println("response = " + response.body().getRet_msg());
//
//            }
//
//            @Override
//            public void onFailure(Call<LoginBean> call, Throwable t) {
//
//            }
//        });


//        public Call<LoginBean> getPath(@Path("type") String type,@QueryMap Map<String,String> map);
//
//
//        loginService.getPath("login",map).enqueue(new Callback<LoginBean>() {
//            @Override
//            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
//
//                System.out.println("response = " + response.body().getRet_msg());
//
//            }
//
//            @Override
//            public void onFailure(Call<LoginBean> call, Throwable t) {
//
//            }
//        });







        ////////////////// ////////////////// ////////////////// ////////////////// ////////////////// ////////////////// //////////////////

//        post

//
//        public Call<LoginBean> postLogin(@Field("username") String username, @Field("password") String password,@Field("postkey") String postkey);
//
//        loginService.postLogin(username,password,postkey).enqueue(new Callback<LoginBean>() {
//            @Override
//            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
//                System.out.println("response = " + response.body().getRet_msg());
//
//
//                Toast.makeText(MainActivity.this, ""+response.body().getRet_msg(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<LoginBean> call, Throwable t) {
//
//            }
//        });

//        public Call<LoginBean> postLoginMap(@FieldMap Map<String,String> map);
//
//
//        loginService.postLoginMap(map).enqueue(new Callback<LoginBean>() {
//            @Override
//            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
//
//                System.out.println("response = " + response.body().getRet_msg());
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//
//            }
//        });

//
//
//
//        loginService.postBody(new User(username,password,postkey)).enqueue(new Callback<LoginBean>() {
//            @Override
//            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
//
//
//                System.out.println("response = " + response.body().getRet_msg());
//x
//            }
//
//            @Override
//            public void onFailure(Call<LoginBean> call, Throwable t) {
//
//            }
//        });



//        loginService.loginUrl("http://qhb.2dyt.com/Bwei/login",map).enqueue(new Callback<LoginBean>() {
//            @Override
//            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
//
//                System.out.println("response = " + response.body().getRet_msg());
//            }
//
//            @Override
//            public void onFailure(Call<LoginBean> call, Throwable t) {
//
//            }
//        });

        loginService.get("http://qhb.2dyt.com/Bwei/login",map).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                System.out.println("response = " + response.body());

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });






    }


    //

    public static final int IMAGE = 1 ;
    public static final int CAMERA = 2 ;

    public static String photoCacheDir = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Bwei";

    public void toPic(){

        if(!new File(photoCacheDir).exists()){
            new File(photoCacheDir).mkdirs();
        }

        Intent getAlbum = new Intent(Intent.ACTION_GET_CONTENT);
        getAlbum.setType("image/*");
        startActivityForResult(getAlbum, 1);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            switch (requestCode) {

                case 1:

                    try {
                        // 相册

                        if (data == null)// 如果没有获取到数据
                            return;
                        Uri originalUri = data.getData();
                        //文件大小判断

                        if (originalUri != null) {
                            File file = null;
                            String[] proj = {MediaStore.Images.Media.DATA};
                            Cursor actualimagecursor = managedQuery(originalUri, proj, null, null, null);
                            if (null == actualimagecursor) {
                                if (originalUri.toString().startsWith("file:")) {
                                    file = new File(originalUri.toString().substring(7, originalUri.toString().length()));
                                    if(!file.exists()){
                                        //地址包含中文编码的地址做utf-8编码
                                        originalUri = Uri.parse(URLDecoder.decode(originalUri.toString(),"UTF-8"));
                                        file = new File(originalUri.toString().substring(7, originalUri.toString().length()));
                                    }
                                }
                            } else {
                                // 系统图库
                                int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                                actualimagecursor.moveToFirst();
                                String img_path = actualimagecursor.getString(actual_image_column_index);
                                if (img_path == null) {
                                    InputStream inputStrean = getContentResolver().openInputStream(originalUri);
                                    file = new File(photoCacheDir+"/aa.jpg");
                                    if(!file.exists()){
                                        file.createNewFile();
                                    }
                                    System.out.println(" - " + file.exists());
                                    FileOutputStream outputStream = new FileOutputStream(file);

                                    byte[] buffer = new byte[1024];
                                    int len = 0;
                                    while ((len = inputStrean.read(buffer)) != -1) {
                                        outputStream.write(buffer, 0, len);
                                    }
                                    outputStream.flush();

                                    if (inputStrean != null) {
                                        inputStrean.close();
                                        inputStrean = null;
                                    }

                                    if (outputStream != null) {
                                        outputStream.close();
                                        outputStream = null;
                                    }
                                } else {
                                    file = new File(img_path);
                                }
                            }
                            String camerFileName = String.valueOf(System.currentTimeMillis()) + ".jpg";
                            File newfilenew = new File(photoCacheDir,camerFileName);
//                            if (!newfilenew.exists()) {
//                                newfilenew.createNewFile();
//                            }
                            FileInputStream inputStream = new FileInputStream(file);
                            FileOutputStream outStream = new FileOutputStream(newfilenew);

                            try {
                                byte[] buffer = new byte[1024];
                                int len = 0;
                                while ((len = inputStream.read(buffer)) != -1) {
                                    outStream.write(buffer, 0, len);
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }finally {
                                try {
                                    inputStream.close();
                                    outStream.close();
                                    inputStream = null;
                                    outStream = null;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            uploadFile(newfilenew.toString());

//                            uploadFile(newfilenew);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;

            }


        }


    }

    private void uploadFile(String string) {


        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://qhb.2dyt.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        LoginService loginservice =  retrofit.create(LoginService.class);


        String [] arr =  string.split("\\|");

        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),new File(string));

        MultipartBody multiBody = new MultipartBody.Builder()
                .addFormDataPart("1111111",arr[arr.length-1],requestBody).build();

//        loginservice.uploadPhoto(multiBody).enqueue(new Callback<Ret>() {
//            @Override
//            public void onResponse(Call<Ret> call, Response<Ret> response) {
//                try {
//                    System.out.println("response = " + response.body().getPath());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Ret> call, Throwable t) {
//
//            }
//        });


//
//
//        MultipartBody.Part part =  MultipartBody.Part.createFormData("image",arr[arr.length-1],requestBody);
//
//        loginservice.uploadPhoto1(part).enqueue(new Callback<Ret>() {
//            @Override
//            public void onResponse(Call<Ret> call, Response<Ret> response) {
//                System.out.println("response = " + response.body().getPath());
//            }
//
//            @Override
//            public void onFailure(Call<Ret> call, Throwable t) {
//
//            }
//        });







    }


}
