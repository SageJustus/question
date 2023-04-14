import React, {useState} from 'react';
import {UploadOutlined} from '@ant-design/icons';
import './App.css';
import {Button, Upload, UploadFile, UploadProps} from 'antd';

function App() {

  const [fileList, setFileList] = useState<UploadFile[]>([
    {
      uid: '-1',
      name: 'image.png',
      status: 'done',
      url: 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png',
    },
    {
      uid: '-2',
      name: 'image.png',
      status: 'done',
      url: 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png',
    },
    {
      uid: '-3',
      name: 'image.png',
      status: 'done',
      url: 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png',
    },
    {
      uid: '-4',
      name: 'image.png',
      status: 'done',
      url: 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png',
    },
    {
      uid: '-xxx',
      percent: 50,
      name: 'image.png',
      status: 'uploading',
      url: 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png',
    },
    {
      uid: '-5',
      name: 'image.png',
      status: 'error',
    },
  ]);

  const props: UploadProps = {
    onChange: ({fileList: newFileList}) => {
      setFileList([...newFileList])
      console.log(2)
      newFileList.forEach(it => console.log(it))
    },
    customRequest: ({onSuccess, file}) => {
      console.log(1)
      onSuccess?.(file)
    },
    fileList: fileList
  };

  return (
    <Upload {...props}>
      <Button icon={<UploadOutlined/>}>Upload</Button>
    </Upload>
  );
}

export default App;
