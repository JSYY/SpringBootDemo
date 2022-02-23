import * as $pbjs from 'protobufjs';

class ParseProtobufService {
  /**
 *base64字符=>Uint8Array
 */
  Decode(base64Content: string): Uint8Array {
    if (!$pbjs.util.base64.test(base64Content)) {
      throw new Error('invalid base64Content');
    }
    let array: Uint8Array = new Uint8Array(2000000);
    const count = $pbjs.util.base64.decode(base64Content, array, 0);
    array = array.slice(0, count);
    return array;
  }
  /**
   *data编码成base64
   */
  Encode(handler:any, data: any): string {
    const val = handler.create(data);
    const res = handler.encode(val).finish();
    const re = $pbjs.util.base64.encode(res, 0, res.length);
    return re;
  }
}
export default new ParseProtobufService()