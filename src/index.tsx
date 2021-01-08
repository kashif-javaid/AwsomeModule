import { NativeModules, requireNativeComponent } from 'react-native';

type AwesomeModuleType = {
  multiply(a: number, b: number): Promise<number>;
};
export const ReactNativeStripeCardInput = requireNativeComponent(
  'ReactNativeStripeCardInput'
);

export const ReactNativeStripeCardInputText = requireNativeComponent(
  'ReactNativeStripeCardInputText'
);

const { AwesomeModule } = NativeModules;

export default AwesomeModule as AwesomeModuleType;
