package cn.ololee.fileclassifier;

import android.Manifest;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import cn.ololee.fileclassifier.classifier.AudioVideoFileClassifier;
import cn.ololee.fileclassifier.classifier.FileClassifier;
import cn.ololee.fileclassifier.classifier.ImageFileClassifier;
import cn.ololee.fileclassifier.databinding.ActivityMainBinding;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;
  public static final String TAG = "MainActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    requestPermissions(new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE }, 101);
    try {
      FileClassifierHelper.init();
      long old = System.currentTimeMillis();
      FileClassifierHelper.getFiles("/sdcard", new FileClassifier() {
            @Override public boolean useMask() {
              return true;
            }

            @Override public int mask() {
              return DefaultConstants.FileTypeConstants.PARENT_MASK;
            }

            @Override public int[] acceptTypes() {
              return new int[] {
                  DefaultConstants.FileTypeConstants.TYPE_IMAGE&DefaultConstants.FileTypeConstants.PARENT_MASK,
              };
            }

            @Override public boolean returnFile() {
              return false;
            }
          },
          new FileInfoCallback() {
            @Override public void updateFileInfoList(List<FileInfo> fileInfoList) {
              Log.d(TAG, "updateFileInfoList:" + fileInfoList.size());
            }

            @Override public void updateFileList(List<File> fileList) {
              Log.d(TAG, "updateFileList:" + fileList);
            }
          });
      long cost = System.currentTimeMillis() - old;
      Log.d(TAG, "ololeeCost:" + cost);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    FileClassifierHelper.clearTrie();
  }
}