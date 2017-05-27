package scott.noa.com.cry.bluetooth.message;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import scott.noa.com.cry.bluetooth.UUIDHelper;

/**
 * Created by scottwang on 17/5/9.
 */

public class Peripheral extends BluetoothGattCallback {

    public static final String LOG_TAG = Peripheral.class.getName();

    private static final String CHARACTERISTIC_NOTIFICATION_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";

    private boolean connected = false;
    private BluetoothDevice device;
    private BluetoothGatt gatt;
    private List<byte[]> writeQueue = new ArrayList<>();

    private BluetootheCallback writeCallback;

    public void connect(Context context, BluetoothDevice device, BluetootheCallback callback) {
        if (!connected) {
            writeQueue.clear();
            writeCallback = callback;
            this.device = device;
            gatt = device.connectGatt(context, false, this);
        }
    }

    public void disconnect(Context context) {
        if (gatt != null) {
            this.gatt.disconnect();
        }
    }

    @Override
    public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
        super.onConnectionStateChange(gatt, status, newState);
        Log.e(LOG_TAG, " -- > onConnectionStateChange");
        this.gatt = gatt;
        if (newState == BluetoothGatt.STATE_CONNECTED) {
            connected = true;
            gatt.discoverServices();
        } else if (newState == BluetoothGatt.STATE_DISCONNECTED) {
            if (connected) {
                connected = false;
                if (gatt != null) {
                    gatt.disconnect();
                    gatt.close();
                    this.gatt = null;
                }
            }
        }
        writeCallback.onConnectionStateChange(newState, gatt);
    }

    @Override
    public void onServicesDiscovered(BluetoothGatt gatt, int status) {
        super.onServicesDiscovered(gatt, status);
        Log.e(LOG_TAG, " -- > onServicesDiscovered");

        writeCallback.onServicesDiscovered(gatt, status);
    }

    @Override
    public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        super.onCharacteristicRead(gatt, characteristic, status);
        Log.e(LOG_TAG, " -- > onCharacteristicRead");

        writeCallback.onCharacteristicRead(gatt, characteristic, status);
    }

    @Override
    public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        super.onCharacteristicWrite(gatt, characteristic, status);
        if (writeCallback != null) {
            if (writeQueue.size() > 0) {
                byte[] data = writeQueue.get(0);
                writeQueue.remove(0);
                doWrite(characteristic, data);
            } else {

                if (status == BluetoothGatt.GATT_SUCCESS) {
                    writeCallback.invoke("GATT_SUCCESS");
                } else {
                    writeCallback.invoke("Error writing status: " + status);
                }
            }

        } else {
            Log.e(LOG_TAG, "No callback on write");
        }
    }

    @Override
    public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        super.onCharacteristicChanged(gatt, characteristic);
        if (writeCallback != null) {
            writeCallback.onCharacteristicChanged(gatt, characteristic);
        }
    }

    @Override
    public void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        super.onDescriptorRead(gatt, descriptor, status);
        Log.e(LOG_TAG, " -- > onDescriptorRead");
    }

    @Override
    public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        super.onDescriptorWrite(gatt, descriptor, status);

        Log.e(LOG_TAG, " -- > onDescriptorWrite");
        writeCallback.onDescriptorWrite(gatt, descriptor, status);
    }

    @Override
    public void onReliableWriteCompleted(BluetoothGatt gatt, int status) {
        super.onReliableWriteCompleted(gatt, status);
        Log.e(LOG_TAG, " -- > onReliableWriteCompleted");
    }

    @Override
    public void onReadRemoteRssi(BluetoothGatt gatt, int rssi, int status) {
        super.onReadRemoteRssi(gatt, rssi, status);
        Log.e(LOG_TAG, " -- > onReadRemoteRssi");
        if(writeCallback!=null){
            writeCallback.onReadRemoteRssi(gatt, rssi, status);
        }
    }

    public void readRssi(){
        if (gatt == null) {
            return;
        }else{
            gatt.readRemoteRssi();
        }
    }

    public void registerNotify(UUID serviceUUID, UUID characteristicUUID, BluetootheCallback callback) {
        //registerNotify
        this.setNotify(serviceUUID, characteristicUUID, true, callback);
    }

    public void removeNotify(UUID serviceUUID, UUID characteristicUUID, BluetootheCallback callback) {
        //removeNotify
        this.setNotify(serviceUUID, characteristicUUID, false, callback);
    }

    public void read(UUID serviceUUID, UUID characteristicUUID, BluetootheCallback callback) {
        if (gatt == null) {
            callback.invoke("BluetoothGatt is null");
            return;
        }

        BluetoothGattService service = gatt.getService(serviceUUID);
        BluetoothGattCharacteristic characteristic = findReadableCharacteristic(service, characteristicUUID);

        if (characteristic == null) {
            callback.invoke("Characteristic " + characteristicUUID + " not found.");
        } else {
            if (!gatt.readCharacteristic(characteristic)) {
                callback.invoke("Read failed");
            }
        }
    }

    public void doWrite(BluetoothGattCharacteristic characteristic, byte[] data) {
        characteristic.setValue(data);

        if (!gatt.writeCharacteristic(characteristic)) {
            //Log.d(LOG_TAG, "Error on doWrite");
        }
    }

    public void write(UUID serviceUUID, UUID characteristicUUID, byte[] data, Integer maxByteSize, Integer queueSleepTime, BluetootheCallback callback, int writeType) {
        if (gatt == null) {
            callback.invoke("BluetoothGatt is null");
        } else {
            BluetoothGattService service = gatt.getService(serviceUUID);
            BluetoothGattCharacteristic characteristic = findWritableCharacteristic(service, characteristicUUID, writeType);

            if (characteristic == null) {
                callback.invoke("Characteristic " + characteristicUUID + " not found.");
            } else {
                characteristic.setWriteType(writeType);

                if (writeQueue.size() > 0) {
                    callback.invoke("You have already an queued message");
                    writeQueue.add(data);
                } else {
                    if (writeQueue.size() == 0) {

                        if (BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT == writeType) {
                            writeCallback = callback;
                        }

                        if (data.length > maxByteSize) {
                            int dataLength = data.length;
                            int count = 0;
                            byte[] firstMessage = null;
                            List<byte[]> splittedMessage = new ArrayList<>();

                            while (count < dataLength && (dataLength - count > maxByteSize)) {
                                if (count == 0) {
                                    firstMessage = Arrays.copyOfRange(data, count, count + maxByteSize);
                                } else {
                                    byte[] splitMessage = Arrays.copyOfRange(data, count, count + maxByteSize);
                                    splittedMessage.add(splitMessage);
                                }
                                count += maxByteSize;
                            }
                            if (count < dataLength) {
                                // Other bytes in queue
                                byte[] splitMessage = Arrays.copyOfRange(data, count, data.length);
                                splittedMessage.add(splitMessage);
                            }

                            if (BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT == writeType) {
                                writeQueue.addAll(splittedMessage);
                                doWrite(characteristic, firstMessage);
                            } else {
                                try {
                                    doWrite(characteristic, firstMessage);
                                    Thread.sleep(queueSleepTime);
                                    for (byte[] message : splittedMessage) {
                                        doWrite(characteristic, message);
                                        Thread.sleep(queueSleepTime);
                                    }
                                } catch (InterruptedException e) {
                                    callback.invoke("Error during writing");
                                }
                            }
                        } else {
                            characteristic.setValue(data);
                            if (gatt.writeCharacteristic(characteristic)) {
                                Log.d(LOG_TAG, "Write completed");
                                if (BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE == writeType) {
                                    callback.invoke("Write  WRITE_TYPE_NO_RESPONSE");
                                }
                            } else {
                                callback.invoke("Write failed");
                            }
                        }
                    }
                }
            }
        }

    }


    // Some peripherals re-use UUIDs for multiple characteristics so we need to check the properties
    // and UUID of all characteristics instead of using service.getCharacteristic(characteristicUUID)
    private BluetoothGattCharacteristic findReadableCharacteristic(BluetoothGattService service, UUID characteristicUUID) {
        BluetoothGattCharacteristic characteristic = null;

        int read = BluetoothGattCharacteristic.PROPERTY_READ;

        List<BluetoothGattCharacteristic> characteristics = service.getCharacteristics();
        for (BluetoothGattCharacteristic c : characteristics) {
            if ((c.getProperties() & read) != 0 && characteristicUUID.equals(c.getUuid())) {
                characteristic = c;
                break;
            }
        }

        // As a last resort, try and find ANY characteristic with this UUID, even if it doesn't have the correct properties
        if (characteristic == null) {
            characteristic = service.getCharacteristic(characteristicUUID);
        }

        return characteristic;
    }

    private void setNotify(UUID serviceUUID, UUID characteristicUUID, Boolean notify, BluetootheCallback callback) {
        BluetoothGattService service = gatt.getService(serviceUUID);
        BluetoothGattCharacteristic characteristic = findNotifyCharacteristic(service, characteristicUUID);
        if (characteristic != null) {
            if (gatt.setCharacteristicNotification(characteristic, notify)) {
                BluetoothGattDescriptor descriptor = characteristic.getDescriptor(UUIDHelper.uuidFromString(CHARACTERISTIC_NOTIFICATION_CONFIG));
                if (descriptor != null) {
                    if ((characteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0) {
                        descriptor.setValue(notify ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                    } else if ((characteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0) {
                        descriptor.setValue(notify ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                    } else {
                        //"Characteristic " + characteristicUUID + " does not have NOTIFY or INDICATE property set");
                    }

                    try {
                        if (gatt.writeDescriptor(descriptor)) {
                            // "setNotify complete"
                        } else {
                            //Failed to set client characteristic notification for characteristicUUID
                        }
                    } catch (Exception e) {
                        //Error on setNotify
                        //Failed to set client characteristic notification for characteristicUUID
                    }
                } else {
                    //Set notification failed for characteristicUUID
                }
            } else {
                //Failed to register notification for characteristicUUID
            }
        } else {
            //not found
        }
    }

    private BluetoothGattCharacteristic findNotifyCharacteristic(BluetoothGattService service, UUID characteristicUUID) {
        BluetoothGattCharacteristic characteristic = null;
        List<BluetoothGattCharacteristic> characteristics = service.getCharacteristics();
        for (BluetoothGattCharacteristic c : characteristics) {
            if ((c.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0 && characteristicUUID.equals(c.getUuid())) {
                characteristic = c;
                break;
            }
        }
        if (characteristic != null) return characteristic;
        // If there wasn't Notify Characteristic, check for Indicate
        for (BluetoothGattCharacteristic c : characteristics) {
            if ((c.getProperties() & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0 && characteristicUUID.equals(c.getUuid())) {
                characteristic = c;
                break;
            }
        }
        if (characteristic == null) {
            characteristic = service.getCharacteristic(characteristicUUID);
        }
        return characteristic;
    }

    // Some peripherals re-use UUIDs for multiple characteristics so we need to check the properties
    // and UUID of all characteristics instead of using service.getCharacteristic(characteristicUUID)
    private BluetoothGattCharacteristic findWritableCharacteristic(BluetoothGattService service, UUID characteristicUUID, int writeType) {
        try {
            BluetoothGattCharacteristic characteristic = null;

            // get write property
            int writeProperty = BluetoothGattCharacteristic.PROPERTY_WRITE;
            if (writeType == BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE) {
                writeProperty = BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE;
            }

            List<BluetoothGattCharacteristic> characteristics = service.getCharacteristics();
            for (BluetoothGattCharacteristic c : characteristics) {
                if ((c.getProperties() & writeProperty) != 0 && characteristicUUID.equals(c.getUuid())) {
                    characteristic = c;
                    break;
                }
            }

            // As a last resort, try and find ANY characteristic with this UUID, even if it doesn't have the correct properties
            if (characteristic == null) {
                characteristic = service.getCharacteristic(characteristicUUID);
            }

            return characteristic;
        } catch (Exception e) {
            //Log.e(LOG_TAG, "Error on findWritableCharacteristic", e);
            return null;
        }
    }
}
