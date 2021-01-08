import { NativeModules, requireNativeComponent } from 'react-native';

type AwesomeModuleType = {
  multiply(a: number, b: number): Promise<number>;
};
export const ReactNativeStripeCardInput = requireNativeComponent(
  'ReactNativeStripeCardInput'
);

const { AwesomeModule } = NativeModules;

export default AwesomeModule as AwesomeModuleType;
